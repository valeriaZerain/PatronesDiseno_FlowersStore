public class FeedStockCounterXML extends FeedStockCounter {

    @Override
    protected FeedParser buildParser() {
        return new FeedParserXML();
    }
}
