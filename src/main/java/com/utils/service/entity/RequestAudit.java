package com.utils.service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "Request_Audit", catalog = "", schema = "",
		uniqueConstraints = @UniqueConstraint(columnNames = { "request_id", "service_name" }))
public class RequestAudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;


	@Column(name = "request_id")
	private String requestId;

	@Column(name = "service_name")
	private String serviceName;

	public RequestAudit(String requestId, String serviceName) {
		this.requestId = requestId;
		this.serviceName = serviceName;
	}
}
