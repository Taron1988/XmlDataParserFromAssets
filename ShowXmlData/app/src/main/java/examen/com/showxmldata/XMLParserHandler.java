package examen.com.showxmldata;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParserHandler {

    private List<UserModel> users;
    private UserModel user;
    private String text;

    XMLParserHandler() {
        users = new ArrayList<>();
    }

    List<UserModel> parse(InputStream in) {

        XmlPullParserFactory factory ;
        XmlPullParser parser;

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(in, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG: {
                        if (tagName.equalsIgnoreCase("user")) {
                            user = new UserModel();
                        }
                        break;
                    }
                    case XmlPullParser.TEXT: {
                        text = parser.getText();
                        break;
                    }
                    case XmlPullParser.END_TAG: {

                        if (tagName.equalsIgnoreCase("user")) {
                            users.add(user);
                        } else if (tagName.equalsIgnoreCase("name")) {
                            user.setName(text);
                        } else if (tagName.equalsIgnoreCase("email")) {
                            user.setEmail(text);
                        } else if (tagName.equalsIgnoreCase("gender")) {
                            user.setGender(text);
                        } else if (tagName.equalsIgnoreCase("age")) {
                            user.setAge(Integer.parseInt(text));
                        }
                        break;
                    }
                    default:
                        break;

                }
                eventType = parser.next();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
}