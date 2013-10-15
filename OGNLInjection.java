import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;


public class OGNLInjection {
	public static void main (String[] args) {
		try {

            // dimension.width
            // (#rt = @java.lang.Runtime@getRuntime(),#rt.exec(\"auditworkbench\"))

			OgnlContext ctx = new OgnlContext();

			Dimension d = new Dimension();
			d.setSize(100,200) ;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("dimension", d);
			//String expressionString0 = "dimension.width == 100 && dimension.height == 200";
            String expressionString0 = args[0];
			Object expr0 = Ognl.parseExpression(expressionString0);
			Object value0 = Ognl.getValue(expr0, ctx, map);
			System.out.println("Value: " + value0);


			//String expressionString1 = "#rt = @java.lang.Runtime@getRuntime()";
			//String expressionString2 = "#rt.exec(\"auditworkbench\")";
			//Object expr1 = Ognl.parseExpression(expressionString1);
			//Object expr2 = Ognl.parseExpression(expressionString2);
			//Object value1 = Ognl.getValue(expr1, ctx, d);
			//Object value2 = Ognl.getValue(expr2, ctx, d);
			//System.out.println("Value: " + value1);
			//System.out.println("Value: " + value2);

		} catch (OgnlException e) {
			e.printStackTrace();
		}
	}
}
