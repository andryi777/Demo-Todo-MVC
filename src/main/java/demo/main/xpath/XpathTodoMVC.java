package demo.main.xpath;

public class XpathTodoMVC {

	private static XpathTodoMVC obj = null;

	private XpathTodoMVC() {
	}

	public static XpathTodoMVC getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XpathTodoMVC();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public final String txtItem = "//*[@class='new-todo']";
	
	public String rbnItem(String ItemName){
		return "//label[text()='"+ItemName+"']/preceding-sibling::input[@type='checkbox']";
	}

	public String lblCounter() {
		return "//*[@class='todo-count']/strong";
	}
	
	public String listItems(){
		return "//*[@class='todo-list']/li";
	}
	
	public String btnClearCompleted() {
		return "//*[@class='clear-completed']";
	}
	
	public String btnActive() {
		return "//*[@class='filters']//a[text()='Active']";
	}
	
	public String item(String ItemName ) {
		return "//label[text()='"+ItemName+"']";
	}
	
	public String btnCompleted() {
		return "//*[@class='filters']//a[text()='Completed']";
	}
	
	public String btnDelete(String itemName) {
		return "//label[text()='"+itemName+"']/following-sibling::button[@class='destroy']";
	}
}
