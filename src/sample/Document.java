package sample;

public class Document {

    public Document(String docNo, String title, String anAbstract) {
        DocNo = docNo;
        Title = title;
        Abstract = anAbstract;
    }

    private String DocNo;
    private String Title;
    private String Abstract;

    public String getDocNo() {
        return DocNo;
    }

    public void setDocNo(String docNo) {
        DocNo = docNo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    @Override
    public String toString() {
        return  Title;
    }
}
