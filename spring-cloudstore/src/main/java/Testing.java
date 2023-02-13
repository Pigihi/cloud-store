import java.util.ArrayList;
import java.util.List;


class TestObject {
	private int id = 234;
	private String name = "Soman Pilla";
	private Boolean flag = true;

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public void show() {
		System.out.println("Id: " + this.id + ", Name: " + this.name + ", Flag: " + this.flag);
	}
}


public class Testing {

	public static void main(String args[]) {
		System.out.println("Testing java file");

		TestObject testObject = new TestObject();
		TestObject testObject1 = new TestObject();
		TestObject testObject2 = new TestObject();
		TestObject testObject3 = new TestObject();
		TestObject testObject4 = new TestObject();
		List<TestObject> testObjects = new ArrayList<>();
		testObjects.add(testObject);
//		testObject1.setFlag(false);
		testObjects.add(testObject1);
		testObjects.add(testObject2);
		testObjects.add(testObject3);
		testObjects.add(testObject4);

//		List<TestObject> newList = new ArrayList<>();
//		for (TestObject test : testObjects) {
//			test.setFlag(false);
//			newList.add(test);
//		}

//		System.out.println("Test Object: " + testObject.show());
		testObject.show();

		for (TestObject test : testObjects) {
			test.show();
		}

		for (TestObject test : testObjects) {
			test.setFlag(false);
		}

		System.out.println("-------------------------------");

		for (TestObject test : testObjects) {
			test.show();
		}

		System.out.println("================================");

//		for (TestObject test : newList) {
//			test.show();
//		}

	}
}
