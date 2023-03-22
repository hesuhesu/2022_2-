package ProgrammingLanguage;

import java.io.*;

/**
 * Recursive Descent Parser of simple expression
 * 
 * EBNF of our grammar 
 * <command> -> <expr>\n 
 * <expr> -> <term> {+ <term>}
 * <term> -> <factor> {* <factor>}
 * <factor> -> <number> | (<expr>)
 * <number> -> <digit>{<digit>}
 * <digit> -> 0|1|2|3|4|5|6|7|8|9
 * 
 * 
 * @author Jangwu Jo
 *
 */
public class RDParser {

	int token, ch;
	private PushbackInputStream input;
	
	RDParser(PushbackInputStream is) {
        input = is;
    }
    
    void error( ) {
        System.out.printf("syntax error\n", token);
        System.exit(1);
    }

    void command( ) {
    /* command -> expr '\n' */
        expr();
        if (token == '\n') /* end the parse and print the result */
        	System.out.println("good syntax");
        else if (token == 't') {
        	System.out.println("good syntax");
        }
        else error();
    }

    
    
    void expr( ) {
    /* expr -> term { '+' term } */
        term();
        while ((token == '+') | (token == '-')) {
        	if (token == '+') {
        		match('+');
                term();
            
        	}
        	else if (token == '-') {
        		match('-');
                term();
        	}
        }
    }

    void term( ) {
    /* term -> factor { '*' factor } */
       factor();
       while ((token == '*') | (token == '/')) {
           if (token == '*') {
        	   match('*');
               factor();
           }
           else if (token == '/') {
        	   match('/');
               factor();
           }
       }
    }

    void factor() {
    /* factor -> '(' expr ')' | number */
        if (token == '(') {
            match('(');
            expr();
            match(')');
        }
        else {
            number(); 
        }
    }

    void number() {
    /* number -> digit{digit} */
    	digit();
    	while (Character.isDigit(token)) {
    		digit();
    	}
    }
    
    void digit() {
    /* digit -> 0|1|...|9 */	
    	if (Character.isDigit(token))
    		match(token);
    	else
    		error();
    }
    void match(int c) { 
        if (token == c) 
        	token = getToken();
        else error();
    }
    
    int getToken() {
        while(true) {
            try  {
                ch = input.read();
                
                if (ch == ' ' || ch == '\t' || ch == '\r') ;
                else if (ch == 't') {
                    ch = input.read();
                    if (ch == 'r') {
                        ch = input.read();
                        if (ch == 'u') {
                            ch = input.read();
                            if (ch == 'e') {
                                return '1'; // return 1 for true
                            }
                        }
                    }
                }
                else if (ch == 'f') {
                	ch = input.read();
                	if (ch == 'a') {
                		ch = input.read();
                		if (ch == 'l') {
                			ch = input.read();
                			if (ch == 's') {
                				ch = input.read();
                				if (ch == 'e') {
                					return '1';
                				}
                			}
                		}
                	}
                }
                else if (ch == '-') {
                	ch = input.read();
                	if (Character.isDigit(ch)) {
                		return '1';
                	}
                	else {
                		error();
                	}
                }
                else return ch;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
        
    void parse( ) {
        token = getToken(); // get the first character
        command();          // call the parsing command
    }
    
	public static void main(String[] args) { 
		RDParser parser = new RDParser(new PushbackInputStream(System.in));
        while(true) {
            System.out.print(">> ");
            parser.parse();
        }
    }

}
