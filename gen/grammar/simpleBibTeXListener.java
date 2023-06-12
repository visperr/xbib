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
	 * Enter a parse tree produced by the {@code tagEntry}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterTagEntry(simpleBibTeXParser.TagEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagEntry}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitTagEntry(simpleBibTeXParser.TagEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDeclaration}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterStringDeclaration(simpleBibTeXParser.StringDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDeclaration}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitStringDeclaration(simpleBibTeXParser.StringDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preamble}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterPreamble(simpleBibTeXParser.PreambleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preamble}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitPreamble(simpleBibTeXParser.PreambleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comment}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterComment(simpleBibTeXParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comment}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitComment(simpleBibTeXParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#tags}.
	 * @param ctx the parse tree
	 */
	void enterTags(simpleBibTeXParser.TagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#tags}.
	 * @param ctx the parse tree
	 */
	void exitTags(simpleBibTeXParser.TagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(simpleBibTeXParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(simpleBibTeXParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(simpleBibTeXParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(simpleBibTeXParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleBibTeXParser#concatable}.
	 * @param ctx the parse tree
	 */
	void enterConcatable(simpleBibTeXParser.ConcatableContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleBibTeXParser#concatable}.
	 * @param ctx the parse tree
	 */
	void exitConcatable(simpleBibTeXParser.ConcatableContext ctx);
}