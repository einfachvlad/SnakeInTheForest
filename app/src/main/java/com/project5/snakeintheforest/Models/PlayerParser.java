package com.project5.snakeintheforest.Models;

import android.app.Activity;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;


public class PlayerParser {
    private Activity activity;
    private Players players = new Players();
    private final String FILENAME = "players.xml";

    public PlayerParser(Activity activity) {
        this.activity = activity;
    }

    public Players parse() {
        Player player = new Player();
        XmlPullParser xmlPullParser;
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            pullParserFactory.setNamespaceAware(true);
            xmlPullParser = pullParserFactory.newPullParser();

            xmlPullParser.setInput(activity.openFileInput(FILENAME), null);
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG
                        && xmlPullParser.getName().equals("player")) {
                    player.setNickname(xmlPullParser.getAttributeValue(0));
                    player.setScore(xmlPullParser.getAttributeValue(1));
                    players.getPlayers().add(player);
                    player = new Player();
                }
                xmlPullParser.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            players.initialize();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    private String createXML(Players players) {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("UTF-8", true);
            serializer.startTag("", "players");
            for (Player player : players.getPlayers()) {
                serializer.startTag("", "player");
                serializer.attribute("", "name", player.getNickname());
                serializer.attribute("", "score", player.getScore());
                serializer.endTag("", "player");
            }
            serializer.endTag("", "players");
            serializer.endDocument();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    public void writeXML(Players players) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    activity.openFileOutput(FILENAME, activity.MODE_PRIVATE)));
            bw.write(createXML(players));
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
