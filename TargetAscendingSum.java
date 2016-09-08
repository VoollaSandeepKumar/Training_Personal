public class TargetAscendingSum {

	public static void main(String[] args) {
		int[] givenInput = { 19, 8, 3, 12, 1, 50 };
		int maxProduct = 1;
		for (int i = 0; i < givenInput.length; i++) {
			for (int j = 0; j < i; j++) {
				int productLocal = givenInput[i] * givenInput[j];
				if (givenInput[j] < givenInput[i]) {
					if (productLocal > maxProduct) {
						maxProduct = productLocal;
					}
				}
			}
		}
		System.out.println(maxProduct);

	}
}
