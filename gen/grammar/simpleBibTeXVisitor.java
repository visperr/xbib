// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simpleBibTeXParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simpleBibTeXVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simpleBibTeXParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase(simpleBibTeXParser.DatabaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagEntry}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagEntry(simpleBibTeXParser.TagEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDeclaration}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDeclaration(simpleBibTeXParser.StringDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preamble}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreamble(simpleBibTeXParser.PreambleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comment}
	 * labeled alternative in {@link simpleBibTeXParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(simpleBibTeXParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleBibTeXParser#tags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTags(simpleBibTeXParser.TagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleBibTeXParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(simpleBibTeXParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleBibTeXParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(simpleBibTeXParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleBibTeXParser#concatable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatable(simpleBibTeXParser.ConcatableContext ctx);
}