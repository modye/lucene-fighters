package com.zenika.wikipedia;

import java.util.List;

/**
 *
 * @author lboutros
 */
public class Page {

  protected String wikibase_item;
  protected String title;
  protected String text;
  protected String timestamp;
  protected String create_timestamp;
  protected double popularity_score;
  protected List<String> template;
  protected List<String> external_link;
  protected List<String> outgoing_link;
  protected int incoming_links;
  protected List<String> category;
  protected List<String> heading;
  protected int text_bytes;
  protected int version;
  
  public String getWikibase_item() {
    return wikibase_item;
  }

  public void setWikibase_item(String wikibase_item) {
    this.wikibase_item = wikibase_item;
  }

  @Override
  public String toString() {
    return "Page{" + "wikibase_item=" + wikibase_item + ", title=" + title + '}';
  }
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getCreate_timestamp() {
    return create_timestamp;
  }

  public void setCreate_timestamp(String create_timestamp) {
    this.create_timestamp = create_timestamp;
  }

  public double getPopularity_score() {
    return popularity_score;
  }

  public void setPopularity_score(double popularity_score) {
    this.popularity_score = popularity_score;
  }

  public List<String> getTemplate() {
    return template;
  }

  public void setTemplate(List<String> template) {
    this.template = template;
  }

  public List<String> getExternal_link() {
    return external_link;
  }

  public void setExternal_link(List<String> external_link) {
    this.external_link = external_link;
  }

  public List<String> getOutgoing_link() {
    return outgoing_link;
  }

  public void setOutgoing_link(List<String> outgoing_link) {
    this.outgoing_link = outgoing_link;
  }

  public int getIncoming_links() {
    return incoming_links;
  }

  public void setIncoming_links(int incoming_links) {
    this.incoming_links = incoming_links;
  }

  public List<String> getCategory() {
    return category;
  }

  public void setCategory(List<String> category) {
    this.category = category;
  }

  public List<String> getHeading() {
    return heading;
  }

  public void setHeading(List<String> heading) {
    this.heading = heading;
  }

  public int getText_bytes() {
    return text_bytes;
  }

  public void setText_bytes(int text_bytes) {
    this.text_bytes = text_bytes;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  
}
