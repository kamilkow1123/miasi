grammar logic;

POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

program: statement* EOF;

statement: expression
    | if_statement
    ;

if_statement: NUMBER;

expression
    : NUMBER                                                # Number
    | '(' inner=expression ')'                              # Parentheses
    | left=expression operator=POW right=expression         # Power
    | left=expression operator=(MUL|DIV) right=expression     # MultiplicationOrDivision
    | left=expression operator=(ADD|SUB) right=expression     # AdditionOrSubstraction
    ;