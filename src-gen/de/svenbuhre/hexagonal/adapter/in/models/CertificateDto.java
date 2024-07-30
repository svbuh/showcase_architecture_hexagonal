package de.svenbuhre.hexagonal.adapter.in.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import jakarta.annotation.Generated;

/**
 * CertificateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T10:36:55.192017200+02:00[Europe/Berlin]")
public class CertificateDto {

  private UUID id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  private String filename;

  private Long fileSize;

  /**
   * Default constructor
   * @deprecated Use {@link CertificateDto#CertificateDto(UUID, OffsetDateTime, String, Long)}
   */
  @Deprecated
  public CertificateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CertificateDto(UUID id, OffsetDateTime created, String filename, Long fileSize) {
    this.id = id;
    this.created = created;
    this.filename = filename;
    this.fileSize = fileSize;
  }

  public CertificateDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public CertificateDto created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @NotNull @Valid 
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public CertificateDto filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Get filename
   * @return filename
  */
  @NotNull 
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public CertificateDto fileSize(Long fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * Get fileSize
   * @return fileSize
  */
  @NotNull 
  @JsonProperty("fileSize")
  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateDto certificateDto = (CertificateDto) o;
    return Objects.equals(this.id, certificateDto.id) &&
        Objects.equals(this.created, certificateDto.created) &&
        Objects.equals(this.filename, certificateDto.filename) &&
        Objects.equals(this.fileSize, certificateDto.fileSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, filename, fileSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

