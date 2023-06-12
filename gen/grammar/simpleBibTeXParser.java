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
public class simpleBibTeXParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, QuotedContent=5, BracedContent=6, StringType=7, 
		PreambleType=8, CommentType=9, Type=10, Name=11, Number=12, Spaces=13;
	public static final int
		RULE_database = 0, RULE_entry = 1, RULE_tags = 2, RULE_tag = 3, RULE_content = 4, 
		RULE_concatable = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"database", "entry", "tags", "tag", "content", "concatable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'}'", "'='", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "QuotedContent", "BracedContent", "StringType", 
			"PreambleType", "CommentType", "Type", "Name", "Number", "Spaces"
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

	public simpleBibTeXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatabaseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(simpleBibTeXParser.EOF, 0); }
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public DatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterDatabase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitDatabase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitDatabase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseContext database() throws RecognitionException {
		DatabaseContext _localctx = new DatabaseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_database);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0) {
				{
				{
				setState(12);
				entry();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
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
	public static class EntryContext extends ParserRuleContext {
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
	 
		public EntryContext() { }
		public void copyFrom(EntryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagEntryContext extends EntryContext {
		public Token entryType;
		public Token key;
		public TagsContext tags() {
			return getRuleContext(TagsContext.class,0);
		}
		public TerminalNode Type() { return getToken(simpleBibTeXParser.Type, 0); }
		public TerminalNode Name() { return getToken(simpleBibTeXParser.Name, 0); }
		public TagEntryContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterTagEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitTagEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitTagEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreambleContext extends EntryContext {
		public TerminalNode PreambleType() { return getToken(simpleBibTeXParser.PreambleType, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public PreambleContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterPreamble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitPreamble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitPreamble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDeclarationContext extends EntryContext {
		public TerminalNode StringType() { return getToken(simpleBibTeXParser.StringType, 0); }
		public TerminalNode Name() { return getToken(simpleBibTeXParser.Name, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public StringDeclarationContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterStringDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitStringDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitStringDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends EntryContext {
		public TerminalNode CommentType() { return getToken(simpleBibTeXParser.CommentType, 0); }
		public CommentContext(EntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entry);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				_localctx = new TagEntryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				((TagEntryContext)_localctx).entryType = match(Type);
				setState(21);
				((TagEntryContext)_localctx).key = match(Name);
				setState(22);
				match(T__0);
				setState(23);
				tags();
				setState(24);
				match(T__1);
				}
				break;
			case StringType:
				_localctx = new StringDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(StringType);
				setState(27);
				match(Name);
				setState(28);
				match(T__2);
				setState(29);
				content();
				setState(30);
				match(T__1);
				}
				break;
			case PreambleType:
				_localctx = new PreambleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(PreambleType);
				setState(33);
				content();
				setState(34);
				match(T__1);
				}
				break;
			case CommentType:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				match(CommentType);
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
	public static class TagsContext extends ParserRuleContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public TagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterTags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitTags(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitTags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsContext tags() throws RecognitionException {
		TagsContext _localctx = new TagsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tags);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Name) {
				{
				setState(39);
				tag();
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(40);
						match(T__0);
						setState(41);
						tag();
						}
						} 
					}
					setState(46);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(47);
					match(T__0);
					}
				}

				}
			}

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
	public static class TagContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(simpleBibTeXParser.Name, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(Name);
			setState(53);
			match(T__2);
			setState(54);
			content();
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
	public static class ContentContext extends ParserRuleContext {
		public List<ConcatableContext> concatable() {
			return getRuleContexts(ConcatableContext.class);
		}
		public ConcatableContext concatable(int i) {
			return getRuleContext(ConcatableContext.class,i);
		}
		public TerminalNode Number() { return getToken(simpleBibTeXParser.Number, 0); }
		public TerminalNode BracedContent() { return getToken(simpleBibTeXParser.BracedContent, 0); }
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_content);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QuotedContent:
			case Name:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				concatable();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(57);
					match(T__3);
					setState(58);
					concatable();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(Number);
				}
				break;
			case BracedContent:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(BracedContent);
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
	public static class ConcatableContext extends ParserRuleContext {
		public TerminalNode QuotedContent() { return getToken(simpleBibTeXParser.QuotedContent, 0); }
		public TerminalNode Name() { return getToken(simpleBibTeXParser.Name, 0); }
		public ConcatableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).enterConcatable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleBibTeXListener ) ((simpleBibTeXListener)listener).exitConcatable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleBibTeXVisitor ) return ((simpleBibTeXVisitor<? extends T>)visitor).visitConcatable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatableContext concatable() throws RecognitionException {
		ConcatableContext _localctx = new ConcatableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_concatable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==QuotedContent || _la==Name) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\u0004\u0001\rG\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002+\b\u0002\n\u0002\f\u0002.\t\u0002\u0001\u0002"+
		"\u0003\u00021\b\u0002\u0003\u00023\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004<\b"+
		"\u0004\n\u0004\f\u0004?\t\u0004\u0001\u0004\u0001\u0004\u0003\u0004C\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002"+
		"\u0004\u0006\b\n\u0000\u0001\u0002\u0000\u0005\u0005\u000b\u000bJ\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u00042\u0001"+
		"\u0000\u0000\u0000\u00064\u0001\u0000\u0000\u0000\bB\u0001\u0000\u0000"+
		"\u0000\nD\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f"+
		"\u0001\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001"+
		"\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001"+
		"\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0013\u0005"+
		"\u0000\u0000\u0001\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0015\u0005"+
		"\n\u0000\u0000\u0015\u0016\u0005\u000b\u0000\u0000\u0016\u0017\u0005\u0001"+
		"\u0000\u0000\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0005\u0002"+
		"\u0000\u0000\u0019&\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0007\u0000"+
		"\u0000\u001b\u001c\u0005\u000b\u0000\u0000\u001c\u001d\u0005\u0003\u0000"+
		"\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u001f\u0005\u0002\u0000\u0000"+
		"\u001f&\u0001\u0000\u0000\u0000 !\u0005\b\u0000\u0000!\"\u0003\b\u0004"+
		"\u0000\"#\u0005\u0002\u0000\u0000#&\u0001\u0000\u0000\u0000$&\u0005\t"+
		"\u0000\u0000%\u0014\u0001\u0000\u0000\u0000%\u001a\u0001\u0000\u0000\u0000"+
		"% \u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000"+
		"\u0000\u0000\',\u0003\u0006\u0003\u0000()\u0005\u0001\u0000\u0000)+\u0003"+
		"\u0006\u0003\u0000*(\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000/1\u0005\u0001\u0000\u00000/\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u00002\'\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0005\u0001\u0000\u0000"+
		"\u000045\u0005\u000b\u0000\u000056\u0005\u0003\u0000\u000067\u0003\b\u0004"+
		"\u00007\u0007\u0001\u0000\u0000\u00008=\u0003\n\u0005\u00009:\u0005\u0004"+
		"\u0000\u0000:<\u0003\n\u0005\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>C\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@C\u0005\f\u0000\u0000AC\u0005"+
		"\u0006\u0000\u0000B8\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000C\t\u0001\u0000\u0000\u0000DE\u0007\u0000\u0000"+
		"\u0000E\u000b\u0001\u0000\u0000\u0000\u0007\u000f%,02=B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}