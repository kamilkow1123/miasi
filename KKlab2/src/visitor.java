import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class visitor extends logicBaseVisitor<Integer>{
    Map<String, Integer> variables = new HashMap<String, Integer>();
    Map<String, List<logicParser.StatementContext>> functions = new HashMap<>();

    @Override
    public Integer visitNumber(logicParser.NumberContext ctx){ return Integer.parseInt(ctx.NUMBER().getText()); }

    @Override
    public Integer visitVariable(logicParser.VariableContext ctx) {
        String identifier = ctx.ID().getText();
        if (variables.containsKey(identifier)) return variables.get(identifier);

        System.out.println("Cannot access undefined variable");
        return 0;
    }

    @Override
    public Integer visitParentheses(logicParser.ParenthesesContext ctx){
        return this.visit(ctx.inner);
    }

    @Override
    public Integer visitPower(logicParser.PowerContext ctx){
        return (int) Math.pow(this.visit(ctx.left), this.visit(ctx.right));
    }

    @Override
    public Integer visitMultiplicationOrDivision(logicParser.MultiplicationOrDivisionContext ctx){
        if(ctx.operator.getText().equals("*")){
            return this.visit(ctx.left) * this.visit(ctx.right);
        }

        return this.visit(ctx.left) / this.visit(ctx.right);
    }

    @Override
    public Integer visitAdditionOrSubstraction(logicParser.AdditionOrSubstractionContext ctx){
        if(ctx.operator.getText().equals("+")){
            return this.visit(ctx.left) + this.visit(ctx.right);
        }

        return this.visit(ctx.left) - this.visit(ctx.right);
    }

    @Override
    public Integer visitComparison(logicParser.ComparisonContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        switch (ctx.operator.getType()){
            case logicLexer.GT -> {
                return left > right ? 1 : 0;
            }
            case logicLexer.LT -> {
                return left < right ? 1 : 0;
            }
            case logicLexer.EQ -> {
                return Objects.equals(left, right) ? 1 : 0;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public Integer visitAssign_variable(logicParser.Assign_variableContext ctx) {
        String identifier = ctx.ID().getText();
        int value = visit(ctx.expression());
        variables.put(identifier, value);
        return value;
    }

    @Override
    public Integer visitIf_statement(logicParser.If_statementContext ctx) {
        Integer res = 0;
        if(visit(ctx.condition) != 0){
            for (var expression: ctx.statement()) {
                res = visit(expression);
            }
        } else {
            if(ctx.else_ != null){
                for (var expression: ctx.statement()
                     ) {
                    res = visit(expression);
                }
            }
        }
        return res;
    }

    @Override
    public Integer visitWhile_statement(logicParser.While_statementContext ctx) {
        while (!visit(ctx.condition).equals(0) ){
            for ( var expression: ctx.statement()){
                    visit(expression);
            }
        }

        return 1;
    }

    @Override
    public Integer visitFunction_definition(logicParser.Function_definitionContext ctx) {
        String functionName = ctx.functionName.getText();
        var functionBody = ctx.statement();
        functions.put(functionName, functionBody);

        return 0;
    }

    @Override
    public Integer visitFunction_call(logicParser.Function_callContext ctx) {
        try {
            List<logicParser.StatementContext> functionBody = functions.get(ctx.functionName.getText());
            for (var expression: functionBody) {
                visit(expression);
            }
        } catch (NullPointerException e){
            System.out.println("Cannot call undefined function");
        }
        return 0;
    }

    @Override
    public Integer visitPrintExpression(logicParser.PrintExpressionContext ctx) {
        Integer value = visit(ctx.expression());
        System.out.println(value);

        return 0;
    }
}


