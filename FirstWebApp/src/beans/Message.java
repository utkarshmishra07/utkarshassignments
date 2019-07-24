package beans;
import java.util.ListResourceBundle;
public class Message extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents= {
			{"snacks.pani","panipuri"},
			{"snacks.bhel","bhelpuri"},
			{"snacks.masala","masalapuri"}
	};
}
