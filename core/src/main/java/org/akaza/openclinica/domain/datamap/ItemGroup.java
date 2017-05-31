// default package
// Generated Jul 31, 2013 2:03:33 PM by Hibernate Tools 3.4.0.CR1
package org.akaza.openclinica.domain.datamap;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.akaza.openclinica.domain.DataMapDomainObject;
import org.akaza.openclinica.domain.Status;
import org.akaza.openclinica.domain.user.UserAccount;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 * ItemGroup generated by hbm2java
 */
@Entity
@Table(name = "item_group", uniqueConstraints = @UniqueConstraint(columnNames = "oc_oid"))
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence_name", value = "item_group_item_group_id_seq") })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemGroup extends DataMapDomainObject {

    private int itemGroupId;
    private UserAccount userAccount;
    private Status status;
    private CrfBean crf;
    private String name;
    private Date dateCreated;
    private Date dateUpdated;
    private Integer updateId;
    private String ocOid;
    private List<ItemGroupMetadata> itemGroupMetadatas;
    private String layoutGroupPath;

    public ItemGroup() {
    }

    public ItemGroup(int itemGroupId, CrfBean crf, String ocOid) {
        this.itemGroupId = itemGroupId;
        this.crf = crf;
        this.ocOid = ocOid;
    }

    public ItemGroup(int itemGroupId, UserAccount userAccount, Status status, CrfBean crf, String name, Date dateCreated, Date dateUpdated, Integer updateId,
            String ocOid, List<ItemGroupMetadata> itemGroupMetadatas) {
        this.itemGroupId = itemGroupId;
        this.userAccount = userAccount;
        this.status = status;
        this.crf = crf;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.updateId = updateId;
        this.ocOid = ocOid;
        this.itemGroupMetadatas = itemGroupMetadatas;
    }

    @Id
    @Column(name = "item_group_id", unique = true, nullable = false)
    @GeneratedValue(generator = "id-generator")

    public int getItemGroupId() {
        return this.itemGroupId;
    }

    public void setItemGroupId(int itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Type(type = "status")
    @Column(name = "status_id")
    public Status getStatus() {
        if (status != null) {
            return status;
        } else
            return Status.AVAILABLE;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crf_id", nullable = false)
    public CrfBean getCrf() {
        return this.crf;
    }

    public void setCrf(CrfBean crf) {
        this.crf = crf;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", length = 4, updatable = false)
    public Date getDateCreated() {
        if (dateCreated != null) {
            return dateCreated;
        } else
            return new Date();
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_updated", length = 4)
    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Column(name = "update_id")
    public Integer getUpdateId() {
        return this.updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    @Column(name = "oc_oid", unique = true, nullable = false, length = 40)
    public String getOcOid() {
        return this.ocOid;
    }

    public void setOcOid(String ocOid) {
        this.ocOid = ocOid;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemGroup")
    public List<ItemGroupMetadata> getItemGroupMetadatas() {
        return this.itemGroupMetadatas;
    }

    public void setItemGroupMetadatas(List<ItemGroupMetadata> itemGroupMetadatas) {
        this.itemGroupMetadatas = itemGroupMetadatas;
    }

    @Column(name = "layout_group_path")
    public String getLayoutGroupPath() {
        return layoutGroupPath;
    }

    public void setLayoutGroupPath(String layoutGroupPath) {
        this.layoutGroupPath = layoutGroupPath;
    }

}
