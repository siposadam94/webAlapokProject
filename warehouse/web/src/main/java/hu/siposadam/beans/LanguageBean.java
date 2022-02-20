package hu.siposadam.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String localeCode;
    private static final Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH); //label, value
        countries.put("Hungary", new Locale("hu", "HU"));
    }

    public Map<String, Object> getCountries() {
        return countries;
    }

    public String getLocale() {
        return localeCode;
    }

    public void setLocale(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void localeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }
}
