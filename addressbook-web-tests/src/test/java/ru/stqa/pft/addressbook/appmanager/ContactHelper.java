package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void returnToHomePage() {

        click(By.linkText("home page"));
    }

    public void Home() {
        click(By.linkText("home"));
    }

    public void submitEnter() {

        click(By.xpath("//input[21]"));
    }

    public void gotoAddNewContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getMail());
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitEditContactById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void alert(){
        wd.switchTo().alert().accept();
    }

    public void submitSaveContact() {
        click(By.name("update"));
    }

    public void create(ContactData contact) {
        gotoAddNewContact();
        fillContactForm(contact);
        submitEnter();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        submitEditContactById(contact.getId());
        fillContactForm(contact);
        submitSaveContact();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        alert();
        Home();
    }


    public boolean isThereContact() {
        return isThereElement();
    }

    public int getContactCount() {
        return getElementCount();
    }



    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr[@name = 'entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        submitEditContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
