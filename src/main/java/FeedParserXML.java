import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FeedParserXML implements FeedParser{

    @Override
    public List<Flower> parse(String content) {
        List<Flower> flowersData = new ArrayList<Flower>();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new StringReader(content)));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("row");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                int id = Integer.parseInt(getElementValue(element, "id"));
                String name = getElementValue(element, "name");
                int stock = Integer.parseInt(getElementValue(element, "stock"));

                Flower flower = new Flower(id, name, stock);
                flowersData.add(flower);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowersData;
    }

    private String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}
