// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleBibTeXParser}.
 */
public interface simpleBibTeXListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#database}.
	 * @param ctx the parse tree
	 */
	void enterDatabase(simpleBibTeXParser.DatabaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#database}.
	 * @param ctx the parse tree
	 */
	void exitDatabase(simpleBibTeXParser.DatabaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(simpleBibTeXParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(simpleBibTeXParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(simpleBibTeXParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(simpleBibTeXParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntegerValue(simpleBibTeXParser.IntegerValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntegerValue(simpleBibTeXParser.IntegerValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIdValue(simpleBibTeXParser.IdValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIdValue(simpleBibTeXParser.IdValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(simpleBibTeXParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link simpleBibTeXParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(simpleBibTeXParser.StringValueContext ctx);
}