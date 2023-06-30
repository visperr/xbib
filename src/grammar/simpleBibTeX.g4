grammar simpleBibTeX;

database
    : (entry)* EOF
    ;

entry
    :  entryType=Type key=Name ',' tags '}'             #tagEntry
    |  StringType Name '=' content '}'                  #stringDeclaration
    |  PreambleType content '}'                         #preamble
    |  CommentType                                      #comment
    ;

tags
    : (tag (',' tag)* ','?)?
    ;
    
tag
    : INACTIVE? Name '=' content
    ;

content
    : concatable ('#' concatable)*       
    | Number        
    | BracedContent        
    ;
    
concatable
    : QuotedContent
    | Name
    ;

// Lexer

QuotedContent
    : '"' (~('\\' | '{' | '}' | '"') | '\\' . | BracedContent)* '"'
    ;

BracedContent
    : '{' (~('\\' | '{' | '}') | '\\' . | BracedContent)* '}'
    ;


StringType
    : '@' ('s'|'S') ('t'|'T') ('r'|'R') ('i'|'I') ('n'|'N') ('g'|'G') SP? '{'
    ;

PreambleType
    : '@' ('p'|'P') ('r'|'R') ('e'|'E') ('a'|'A') ('m'|'M') ('b'|'B') ('l'|'L') ('e'|'E') SP? '{'
    ;

CommentType
    : '@' ('c'|'C') ('o'|'O') ('m'|'M') ('m'|'M') ('e'|'E') ('n'|'N') ('t'|'T') SP? BracedContent
    | '%' ~[\r\n]*
    ;


Type
    : '@' Letter+ SP? '{'
    ;

Name
    : (Letter | Digit) (Letter | Digit | ':' | '-' | '_' | '.' | '/' | '+')*
    ;

Number
    : Digit+
    ;

INACTIVE
    : '-'
    | '_'
    ;

Spaces
    : SP -> skip;
    
// Fragments

fragment Letter
    : [a-z]
    | [A-Z]
    ;

fragment Digit
    : [0-9]
    ;

fragment SP
  :  (' ' | '\t' | '\r' | '\n' | '\f')+
  ;