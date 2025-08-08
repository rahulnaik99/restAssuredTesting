public class pojo {
    private String url,services,expertise,instruction,linkdien;
    private coursesPOJO coursesPOJO;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public coursesPOJO getCourses() {
        return coursesPOJO;
    }

    public void setCourses(coursesPOJO courses) {
        this.coursesPOJO = courses;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getLinkdien() {
        return linkdien;
    }

    public void setLinkdien(String linkdien) {
        this.linkdien = linkdien;
    }
}
