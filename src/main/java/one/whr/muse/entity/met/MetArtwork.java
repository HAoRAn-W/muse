package one.whr.muse.entity.met;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Met")
public class MetArtwork implements Serializable {
    @Id
    private Long objectID;

    @Indexed(name = "deleteAt", expireAfterSeconds = 0)
    private LocalDateTime expireTime = LocalDate.now().atTime(23, 59, 59);

    private boolean isHighlight;
    private String accessionNumber;
    private String accessionYear;
    private boolean isPublicDomain;
    private String primaryImage;
    private String primaryImageSmall;
    ArrayList < String > additionalImages = new ArrayList<>();
//    private String constituents = null;
    private String department;
    private String objectName;
    private String title;
    private String culture;
    private String period;
    private String dynasty;
    private String reign;
    private String portfolio;
    private String artistRole;
    private String artistPrefix;
    private String artistDisplayName;
    private String artistDisplayBio;
    private String artistSuffix;
    private String artistAlphaSort;
    private String artistNationality;
    private String artistBeginDate;
    private String artistEndDate;
    private String artistGender;
    private String artistWikidata_URL;
    private String artistULAN_URL;
    private String objectDate;
    private Integer objectBeginDate;
    private Integer objectEndDate;
    private String medium;
    private String dimensions;
//    ArrayList< Object > measurements = new ArrayList < Object > ();
    private String creditLine;
    private String geographyType;
    private String city;
    private String state;
    private String county;
    private String country;
    private String region;
    private String subregion;
    private String locale;
    private String locus;
    private String excavation;
    private String river;
    private String classification;
    private String rightsAndReproduction;
    private String linkResource;
    private String metadataDate;
    private String repository;
    private String objectURL;
    ArrayList < MetTag > tags = new ArrayList<>();
    private String objectWikidata_URL;
    private boolean isTimelineWork;
    private String GalleryNumber;
}
