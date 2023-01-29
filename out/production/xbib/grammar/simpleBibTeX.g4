grammar simpleBibTeX;

database
    : entry* EOF
    ;

entry
    : '@' entryType=Identifier '{' key=Identifier ',' (data ',')*data ','? '}'
    ;

data
    : field=Identifier '=' value
    ;

value
    : Integer       #integerValue
    | Identifier    #idValue
    | String        #stringValue
    ;


fragment Letter : [a-zA-Z];

fragment ZeroDigit : [0];
fragment NonZeroDigit : [1-9];
fragment Digit : ZeroDigit | NonZeroDigit;

Integer : (ZeroDigit | NonZeroDigit Digit*);

Identifier : (Letter | Digit | '_' | '-' | ':')+;

String : '{' (ESC | BRACE_ENCLOSED_SAFECODEPOINT)* '}'
       | '"' (ESC | QUOTE_ENCLOSED_SAFECODEPOINT)* '"'
       ;

fragment ESC
   : '\\' (["\\/bfnrt])
   ;

fragment QUOTE_ENCLOSED_SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;

fragment BRACE_ENCLOSED_SAFECODEPOINT
   : ~ [\\\u0000-\u001F]
   ;

WS : [ \t\r\n]+ -> skip;