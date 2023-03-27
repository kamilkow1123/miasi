grammar logic;

POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
GT: '>';
LT: '<';
EQ: '==';

IF: 'if';
END_IF: 'endif';
WHILE: 'while';
END_WHILE: 'endwhile';
FOR: 'for';
END_FOR: 'endfor';
FUNC: 'func';
BEGIN_FUNC: 'beginfunc';
END_FUNC: 'endfunc';
TRUE: 'true';
FALSE: 'false';

ID: [a-zA-Z]+;
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;
PRINT: 'print';

program: statement* EOF;

statement: expression #ExpressionStatement
    | assign_variable #Assign
    | if_statement #IfStatement
    | while_statement #WhileStatement
    | function_definition #FunctionDefinition
    | function_call #FunctionCall
    | PRINT expression #PrintExpression
    ;

assign_variable: ID '=' expression;

if_statement: IF '(' condition=expression ')' then=statement* ('else' else_=statement*)? END_IF;

while_statement: WHILE '(' condition=expression ')' body=statement* END_WHILE;

function_definition: FUNC functionName=ID '('')' BEGIN_FUNC functionBody=statement* END_FUNC;

function_call: functionName=ID '('')';

expression
    : NUMBER                                                    #Number
    | ID                                                        #Variable
    | '(' inner=expression ')'                                  #Parentheses
    | left=expression operator=POW right=expression             #Power
    | left=expression operator=(MUL|DIV) right=expression       #MultiplicationOrDivision
    | left=expression operator=(ADD|SUB) right=expression       #AdditionOrSubstraction
    | left=expression operator=(LT|GT|EQ) right=expression      #Comparison
    ;