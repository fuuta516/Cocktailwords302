package csv;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		CsvReader c = new CsvReader();
		
		DbOperation d = new DbOperation();

		for (int i=0; i<d.dbWordsInfo().size(); i++) {
			d.dbWordsInfo().get(i).show();
		}
	}
}
