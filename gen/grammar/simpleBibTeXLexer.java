// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class simpleBibTeXLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Integer=6, Identifier=7, String=8, 
		WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "Letter", "ZeroDigit", "NonZeroDigit", 
			"Digit", "Integer", "Identifier", "String", "ESC", "QUOTE_ENCLOSED_SAFECODEPOINT", 
			"BRACE_ENCLOSED_SAFECODEPOINT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'{'", "','", "'}'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "Integer", "Identifier", "String", 
			"WS"
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


	public simpleBibTeXLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simpleBibTeX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\th\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0003\b4\b\b\u0001\t\u0001\t\u0001\t\u0005\t9\b\t\n\t\f\t<"+
		"\t\t\u0003\t>\b\t\u0001\n\u0001\n\u0001\n\u0004\nC\b\n\u000b\n\f\nD\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000bJ\b\u000b\n\u000b\f\u000bM\t"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bS\b"+
		"\u000b\n\u000b\f\u000bV\t\u000b\u0001\u000b\u0003\u000bY\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0004\u000fc\b\u000f\u000b\u000f\f\u000fd\u0001\u000f\u0001\u000f\u0000"+
		"\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0000\r\u0000\u000f\u0000\u0011\u0000\u0013\u0006\u0015\u0007\u0017\b"+
		"\u0019\u0000\u001b\u0000\u001d\u0000\u001f\t\u0001\u0000\b\u0002\u0000"+
		"AZaz\u0001\u000000\u0001\u000019\u0003\u0000--::__\b\u0000\"\"//\\\\b"+
		"bffnnrrtt\u0003\u0000\u0000\u001f\"\"\\\\\u0002\u0000\u0000\u001f\\\\"+
		"\u0003\u0000\t\n\r\r  l\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000"+
		"\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000"+
		"\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001"+
		"\u0000\u0000\u0000\r-\u0001\u0000\u0000\u0000\u000f/\u0001\u0000\u0000"+
		"\u0000\u00113\u0001\u0000\u0000\u0000\u0013=\u0001\u0000\u0000\u0000\u0015"+
		"B\u0001\u0000\u0000\u0000\u0017X\u0001\u0000\u0000\u0000\u0019Z\u0001"+
		"\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000\u001d_\u0001\u0000\u0000"+
		"\u0000\u001fb\u0001\u0000\u0000\u0000!\"\u0005@\u0000\u0000\"\u0002\u0001"+
		"\u0000\u0000\u0000#$\u0005{\u0000\u0000$\u0004\u0001\u0000\u0000\u0000"+
		"%&\u0005,\u0000\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005}\u0000\u0000"+
		"(\b\u0001\u0000\u0000\u0000)*\u0005=\u0000\u0000*\n\u0001\u0000\u0000"+
		"\u0000+,\u0007\u0000\u0000\u0000,\f\u0001\u0000\u0000\u0000-.\u0007\u0001"+
		"\u0000\u0000.\u000e\u0001\u0000\u0000\u0000/0\u0007\u0002\u0000\u0000"+
		"0\u0010\u0001\u0000\u0000\u000014\u0003\r\u0006\u000024\u0003\u000f\u0007"+
		"\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u00004\u0012\u0001"+
		"\u0000\u0000\u00005>\u0003\r\u0006\u00006:\u0003\u000f\u0007\u000079\u0003"+
		"\u0011\b\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000=5\u0001\u0000\u0000\u0000=6\u0001\u0000\u0000"+
		"\u0000>\u0014\u0001\u0000\u0000\u0000?C\u0003\u000b\u0005\u0000@C\u0003"+
		"\u0011\b\u0000AC\u0007\u0003\u0000\u0000B?\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0016\u0001\u0000"+
		"\u0000\u0000FK\u0005{\u0000\u0000GJ\u0003\u0019\f\u0000HJ\u0003\u001d"+
		"\u000e\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000JM\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NY\u0005}\u0000\u0000"+
		"OT\u0005\"\u0000\u0000PS\u0003\u0019\f\u0000QS\u0003\u001b\r\u0000RP\u0001"+
		"\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000WY\u0005\"\u0000\u0000XF\u0001\u0000\u0000"+
		"\u0000XO\u0001\u0000\u0000\u0000Y\u0018\u0001\u0000\u0000\u0000Z[\u0005"+
		"\\\u0000\u0000[\\\u0007\u0004\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000"+
		"]^\b\u0005\u0000\u0000^\u001c\u0001\u0000\u0000\u0000_`\b\u0006\u0000"+
		"\u0000`\u001e\u0001\u0000\u0000\u0000ac\u0007\u0007\u0000\u0000ba\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0006\u000f\u0000"+
		"\u0000g \u0001\u0000\u0000\u0000\f\u00003:=BDIKRTXd\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}