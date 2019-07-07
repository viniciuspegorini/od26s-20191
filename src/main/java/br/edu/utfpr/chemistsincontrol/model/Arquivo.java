package br.edu.utfpr.chemistsincontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "uploaded_files")
public class Arquivo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fileName;

    @Column
    private Long size;

    @Lob
    @Column
    @JsonIgnore
    private byte[] content;

    @Column
    @Enumerated
    private EContentType contentType;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public EContentType getContentType() {
        return contentType;
    }

    public void setContentType(EContentType contentType) {
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum EContentType {
        IMG_PNG("image/x-png"),
        IMG_JPEG("image/pjpeg"),
        IMG_BMP("image/bmp"),
        OCTET_STREAM("application/octet-stream"),
        XML("application/xml"),
        PDF("application/pdf");

        private final String contentType;

        EContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getContentType() {
            return contentType;
        }

        public static EContentType valueFromString(String value) {
            for (EContentType type : EContentType.values()) {
                if (type.getContentType().equalsIgnoreCase(value)) {
                    return type;
                }
            }
            return OCTET_STREAM;
        }
    }



}