// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link xbibParser}.
 */
public interface xbibListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link xbibParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(xbibParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link xbibParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(xbibParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void enterMessageCommand(xbibParser.MessageCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void exitMessageCommand(xbibParser.MessageCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code categoryCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCategoryCommand(xbibParser.CategoryCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code categoryCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCategoryCommand(xbibParser.CategoryCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void enterFieldCommand(xbibParser.FieldCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldCommand}
	 * labeled alternative in {@link xbibParser#command}.
	 * @param ctx the parse tree
	 */
	void exitFieldCommand(xbibParser.FieldCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void enterSetItem(xbibParser.SetItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void exitSetItem(xbibParser.SetItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code actionItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void enterActionItem(xbibParser.ActionItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code actionItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void exitActionItem(xbibParser.ActionItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flagItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void enterFlagItem(xbibParser.FlagItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flagItem}
	 * labeled alternative in {@link xbibParser#item}.
	 * @param ctx the parse tree
	 */
	void exitFlagItem(xbibParser.FlagItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link xbibParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(xbibParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link xbibParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(xbibParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link xbibParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(xbibParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link xbibParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(xbibParser.PrimitiveContext ctx);
}