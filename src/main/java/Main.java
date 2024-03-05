public class Main {

    public static void main(String[] args) {
        System.out.println("Inventario de Floreria UPB!!!");

        System.out.println("Lectura de datos CSV");
         //Step 1 Read data
        String CSV_PATH = "data/warehouse-stock.csv";
        FileReaderInventory fileReaderInventory  = new FileReaderInventory(CSV_PATH);
        String csvRecords = fileReaderInventory.readFileContent();

        System.out.println(csvRecords);
        // Step 2 Interpret or parse data
        FeedStockCounterCsv feedStockCounterCsv = new FeedStockCounterCsv();
        System.out.println(feedStockCounterCsv.totalStock(csvRecords));

        System.out.println("Lectura de datos JSON");
        //Read data
        String JSON_PATH = "data/warehouse-stock.json";
        FileReaderInventory fileReaderInventoryJson  = new FileReaderInventory(JSON_PATH);
        String jsonRecords =  fileReaderInventoryJson.readFileContent();
        System.out.println(jsonRecords);
        //Interpret or parse data
        FeedStockCounterJson feedStockCounterJson = new FeedStockCounterJson();
        System.out.println(feedStockCounterJson.totalStock(jsonRecords));

        System.out.println("Lectura de datos XML");
        //Read data
        String XML_PATH = "data/warehouse-stock.xml";
        FileReaderInventory fileReaderInventoryXML = new FileReaderInventory(XML_PATH);
        String xmlRecords = fileReaderInventoryXML.readFileContent();
        System.out.println(xmlRecords);

        //Interpret or parse data
        FeedStockCounterXML feedStockCounterXML = new FeedStockCounterXML();
        System.out.println(feedStockCounterXML.totalStock(xmlRecords));
    }

}