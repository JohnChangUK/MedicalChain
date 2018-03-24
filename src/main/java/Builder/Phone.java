package Builder;

public class Phone {

    private String frontPanel;
    private String backPanel;
    private String processor;
    private String camera;

    private Phone(Builder builder) {
        this.frontPanel = builder.frontPanel;
        this.backPanel = builder.backPanel;
        this.processor = builder.processor;
        this.camera = builder.camera;
    }

    public static class Builder {

        private String frontPanel;
        private String backPanel;
        private String processor;
        private String camera;

        public Builder() {

        }

        public Phone build() {
            return new Phone(this);
        }

        public Builder frontPanel(String frontPanel){
            this.frontPanel = frontPanel;
            return this;
        }

        public Builder backPanel(String backPanel) {
            this.backPanel = backPanel;
            return this;
        }

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder camera(String camera) {
            this.camera = camera;
            return this;
        }
    }

    public String getFrontPanel() {
        return frontPanel;
    }

    public void setFrontPanel(String frontPanel) {
        this.frontPanel = frontPanel;
    }

    public String getBackPanel() {
        return backPanel;
    }

    public void setBackPanel(String backPanel) {
        this.backPanel = backPanel;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "frontPanel='" + frontPanel + '\'' +
                ", backPanel='" + backPanel + '\'' +
                ", processor='" + processor + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
