import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // CharStream input = CharStreams.fromFileName("test.txt");

        // create a lexer that feeds off of input CharStream
        logicLexer lexer = new logicLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        logicParser parser = new logicParser(tokens);

        // start parsing at the program rule
        ParseTree tree = parser.program();
         System.out.println(tree.toStringTree());

        // create a visitor to traverse the parse tree
        visitor visitor = new visitor();
        visitor.visit(tree);
    }
}