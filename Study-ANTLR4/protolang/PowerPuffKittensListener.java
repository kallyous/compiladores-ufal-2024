// Generated from PowerPuffKittens.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PowerPuffKittensParser}.
 */
public interface PowerPuffKittensListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PowerPuffKittensParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PowerPuffKittensParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#stats}.
	 * @param ctx the parse tree
	 */
	void enterStats(PowerPuffKittensParser.StatsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#stats}.
	 * @param ctx the parse tree
	 */
	void exitStats(PowerPuffKittensParser.StatsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(PowerPuffKittensParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(PowerPuffKittensParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PowerPuffKittensParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PowerPuffKittensParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#expr_i}.
	 * @param ctx the parse tree
	 */
	void enterExpr_i(PowerPuffKittensParser.Expr_iContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#expr_i}.
	 * @param ctx the parse tree
	 */
	void exitExpr_i(PowerPuffKittensParser.Expr_iContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PowerPuffKittensParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PowerPuffKittensParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#term_i}.
	 * @param ctx the parse tree
	 */
	void enterTerm_i(PowerPuffKittensParser.Term_iContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#term_i}.
	 * @param ctx the parse tree
	 */
	void exitTerm_i(PowerPuffKittensParser.Term_iContext ctx);
	/**
	 * Enter a parse tree produced by {@link PowerPuffKittensParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PowerPuffKittensParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PowerPuffKittensParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PowerPuffKittensParser.FactorContext ctx);
}