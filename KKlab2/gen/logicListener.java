// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link logicParser}.
 */
public interface logicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link logicParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(logicParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link logicParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(logicParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link logicParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(logicParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link logicParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(logicParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link logicParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(logicParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link logicParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(logicParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(logicParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(logicParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationOrDivision(logicParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationOrDivision(logicParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionOrSubstraction}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionOrSubstraction(logicParser.AdditionOrSubstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionOrSubstraction}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionOrSubstraction(logicParser.AdditionOrSubstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(logicParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(logicParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPower(logicParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link logicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPower(logicParser.PowerContext ctx);
}