// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link xbibParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface xbibVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link xbibParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(xbibParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code categoryCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCategoryCommand(xbibParser.CategoryCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldCommand(xbibParser.FieldCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetItem(xbibParser.SetItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code actionItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionItem(xbibParser.ActionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flagItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagItem(xbibParser.FlagItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link xbibParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(xbibParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link xbibParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(xbibParser.PrimitiveContext ctx);
}