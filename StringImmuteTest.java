
public class StringImmuteTest {
	
	public static void main(String[] args) {
		String sand = "sandeep";
		String sand1 = "sandeep";
		sand = sand+"sandd";
		System.out.println(sand == sand1);
	}

}
