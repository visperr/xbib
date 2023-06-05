// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class xbibParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, Activate=11, Category=12, Word=13, String=14, Integer=15, Boolean=16, 
		Identifier=17, LineComment=18, Comment=19, WS=20;
	public static final int
		RULE_main = 0, RULE_command = 1, RULE_item = 2, RULE_argument = 3, RULE_primitive = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "command", "item", "argument", "primitive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'message'", "';'", "'go'", "'('", "','", "')'", "'field'", "'set'", 
			"'to'", "'action'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "Activate", 
			"Category", "Word", "String", "Integer", "Boolean", "Identifier", "LineComment", 
			"Comment", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public xbibParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(xbibParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 138L) != 0) {
				{
				{
				setState(10);
				command();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldCommandContext extends CommandContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public FieldCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterFieldCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitFieldCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitFieldCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CategoryCommandContext extends CommandContext {
		public Token category;
		public TerminalNode Category() { return getToken(xbibParser.Category, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public CategoryCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterCategoryCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitCategoryCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitCategoryCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MessageCommandContext extends CommandContext {
		public TerminalNode String() { return getToken(xbibParser.String, 0); }
		public MessageCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterMessageCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitMessageCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitMessageCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new MessageCommandContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(T__0);
				setState(19);
				match(String);
				setState(20);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new CategoryCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(T__2);
				setState(22);
				((CategoryCommandContext)_localctx).category = match(Category);
				setState(23);
				match(T__3);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 3328L) != 0) {
					{
					setState(24);
					item();
					setState(29);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(25);
						match(T__4);
						setState(26);
						item();
						}
						}
						setState(31);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(34);
				match(T__5);
				setState(35);
				match(T__1);
				}
				break;
			case T__6:
				_localctx = new FieldCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				match(T__6);
				setState(37);
				argument();
				setState(38);
				argument();
				setState(39);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlagItemContext extends ItemContext {
		public Token call;
		public Token flag;
		public TerminalNode Activate() { return getToken(xbibParser.Activate, 0); }
		public TerminalNode Identifier() { return getToken(xbibParser.Identifier, 0); }
		public FlagItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterFlagItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitFlagItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitFlagItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ActionItemContext extends ItemContext {
		public Token call;
		public Token function;
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(xbibParser.Identifier, 0); }
		public ActionItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterActionItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitActionItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitActionItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetItemContext extends ItemContext {
		public Token call;
		public Token value;
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(xbibParser.Identifier, 0); }
		public SetItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterSetItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitSetItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitSetItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_item);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new SetItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				((SetItemContext)_localctx).call = match(T__7);
				setState(44);
				((SetItemContext)_localctx).value = match(Identifier);
				setState(45);
				match(T__8);
				setState(46);
				argument();
				}
				break;
			case T__9:
				_localctx = new ActionItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				((ActionItemContext)_localctx).call = match(T__9);
				setState(48);
				((ActionItemContext)_localctx).function = match(Identifier);
				setState(49);
				argument();
				}
				break;
			case Activate:
				_localctx = new FlagItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				((FlagItemContext)_localctx).call = match(Activate);
				setState(51);
				((FlagItemContext)_localctx).flag = match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argument);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__3);
				setState(55);
				argument();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(56);
					match(T__4);
					setState(57);
					argument();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(T__5);
				}
				break;
			case Word:
			case String:
			case Integer:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveContext extends ParserRuleContext {
		public Token prim_int;
		public Token prim_enum;
		public Token prim_word;
		public Token prim_string;
		public TerminalNode Integer() { return getToken(xbibParser.Integer, 0); }
		public TerminalNode Identifier() { return getToken(xbibParser.Identifier, 0); }
		public TerminalNode Word() { return getToken(xbibParser.Word, 0); }
		public TerminalNode String() { return getToken(xbibParser.String, 0); }
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xbibListener ) ((xbibListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof xbibVisitor ) return ((xbibVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primitive);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((PrimitiveContext)_localctx).prim_int = match(Integer);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				((PrimitiveContext)_localctx).prim_enum = match(Identifier);
				}
				break;
			case Word:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				((PrimitiveContext)_localctx).prim_word = match(Word);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				((PrimitiveContext)_localctx).prim_string = match(String);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0014K\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001"+
		"\n\u0001\f\u0001\u001f\t\u0001\u0003\u0001!\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001*\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00025\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003;\b"+
		"\u0003\n\u0003\f\u0003>\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003C\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004I\b\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006"+
		"\b\u0000\u0000Q\u0000\r\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000"+
		"\u0000\u00044\u0001\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000\b"+
		"H\u0001\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000"+
		"\u0000\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000"+
		"\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0010\u0001\u0000\u0000\u0000"+
		"\u000f\r\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0000\u0000\u0001\u0011"+
		"\u0001\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013"+
		"\u0014\u0005\u000e\u0000\u0000\u0014*\u0005\u0002\u0000\u0000\u0015\u0016"+
		"\u0005\u0003\u0000\u0000\u0016\u0017\u0005\f\u0000\u0000\u0017 \u0005"+
		"\u0004\u0000\u0000\u0018\u001d\u0003\u0004\u0002\u0000\u0019\u001a\u0005"+
		"\u0005\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \u0018\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0006"+
		"\u0000\u0000#*\u0005\u0002\u0000\u0000$%\u0005\u0007\u0000\u0000%&\u0003"+
		"\u0006\u0003\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005\u0002\u0000\u0000"+
		"(*\u0001\u0000\u0000\u0000)\u0012\u0001\u0000\u0000\u0000)\u0015\u0001"+
		"\u0000\u0000\u0000)$\u0001\u0000\u0000\u0000*\u0003\u0001\u0000\u0000"+
		"\u0000+,\u0005\b\u0000\u0000,-\u0005\u0011\u0000\u0000-.\u0005\t\u0000"+
		"\u0000.5\u0003\u0006\u0003\u0000/0\u0005\n\u0000\u000001\u0005\u0011\u0000"+
		"\u000015\u0003\u0006\u0003\u000023\u0005\u000b\u0000\u000035\u0005\u0011"+
		"\u0000\u00004+\u0001\u0000\u0000\u00004/\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u00005\u0005\u0001\u0000\u0000\u000067\u0005\u0004\u0000"+
		"\u00007<\u0003\u0006\u0003\u000089\u0005\u0005\u0000\u00009;\u0003\u0006"+
		"\u0003\u0000:8\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000?@\u0005\u0006\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000AC\u0003\b\u0004\u0000B6\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000"+
		"\u0000C\u0007\u0001\u0000\u0000\u0000DI\u0005\u000f\u0000\u0000EI\u0005"+
		"\u0011\u0000\u0000FI\u0005\r\u0000\u0000GI\u0005\u000e\u0000\u0000HD\u0001"+
		"\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000I\t\u0001\u0000\u0000\u0000\b\r\u001d )4<BH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}