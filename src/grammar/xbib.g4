grammar xbib;

main
    : command* EOF;

command
    : 'message' String ';' #messageCommand
    | 'go' category=Category '(' (item(','item)*)? ')' ';'     #categoryCommand
    | 'field' argument argument ';'                            #fieldCommand
    ;

item
    : call='set' value=Identifier 'to' argument                 #setItem
    | call='action' function=Identifier argument                #actionItem
    | call=Activate flag=Identifier                             #flagItem
    ;

argument
    : '(' argument(','argument)* ')'
    | primitive
    ;

primitive : prim_int=Integer
          | prim_enum=Identifier
          | prim_word=Word
          | prim_string=String
          ;


Activate : ('enable' | 'disable');

Category : ('format' | 'order' | 'content');

Word : ['] Identifier ['];
String : ["].*?["];

fragment ZeroDigit : [0];
fragment NonZeroDigit : [1-9];
fragment Digit : ZeroDigit | NonZeroDigit;

Integer : (ZeroDigit | NonZeroDigit Digit*);

Boolean : 'true' | 'false';

Identifier : (Letter)(Letter | Digit | '_' | '-' | ':')*;

fragment Letter : [a-zA-Z];

LineComment : '//' ~[\r\n]* -> skip;

Comment : '/*' .*? '*/' -> skip;

WS : [ \t\r\n]+ -> skip;