package it.polito.ai.profile.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "profiles")
public class Profile {

	@Id
	@JsonIgnore
	private String profileId;
	
	@JsonIgnore
	@Indexed(unique = true)
	private String username;
	
	@NotEmpty
	@Indexed(unique = true)
	@Pattern(regexp = "[a-z-A-Z_]*")
	private String nickname;
	
	@Pattern(regexp = "[a-z-A-Z]*")
	private String gender;
	
	@Min(0)
	@Max(120)
	private int age;
	@Pattern(regexp = "(primary)|(middle)|(high)|(bachelor)|(master)|(phd)")
	private String education;
	@Pattern(regexp = "(worker)|(student)|(unemployed)")
	private String job;
	
	@Pattern(regexp = "(yes)|(no)")
	private String ownCar;
	@Pattern(regexp = "(ethanol)|(methanol)|(gasoline)|(diesel)|(naturalGas)|(hydrogen)")
	private String fuel;
	@Min(1900)
	@Max(2017)
	private int registrationCarYear;
	@Pattern(regexp = "(yes)|(no)")
	private String useCarSharing;
	@Pattern(regexp = "(car2go)|(enjoy)")
	private String carSharingCompany;
	
	@Pattern(regexp = "(yes)|(no)")
	private String useBike;
	@Pattern(regexp = "(yes)|(no)")
	private String useownBike;
	@Pattern(regexp = "(yes)|(no)")
	private String useBikeSharing;
	@Pattern(regexp = "(tobike)|(other)")
	private String bikeSharingCompany;
	
	@Pattern(regexp = "(yes)|(no)")
	private String usePublicTransport;
	@Pattern(regexp = "(single)|(weekly)|(annual)|(student)")
	private String frequentTicketType;
	
	private String avatar;
	
	public Profile() {
	}
	
	public Profile(String username, String nickname) {
		this.username = username;
		this.nickname = nickname;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getOwnCar() {
		return ownCar;
	}

	public void setOwnCar(String ownCar) {
		this.ownCar = ownCar;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public int getRegistrationCarYear() {
		return registrationCarYear;
	}

	public void setRegistrationCarYear(int registrationCarYear) {
		this.registrationCarYear = registrationCarYear;
	}

	
	public String getUseCarSharing() {
		return useCarSharing;
	}

	public void setUseCarSharing(String useCarSharing) {
		this.useCarSharing = useCarSharing;
	}

	public String getCarSharingCompany() {
		return carSharingCompany;
	}

	public void setCarSharingCompany(String carSharingCompany) {
		this.carSharingCompany = carSharingCompany;
	}

	public String getUseBike() {
		return useBike;
	}

	public void setUseBike(String useBike) {
		this.useBike = useBike;
	}

	public String getUseownBike() {
		return useownBike;
	}

	public void setUseownBike(String useownBike) {
		this.useownBike = useownBike;
	}

	public String getUseBikeSharing() {
		return useBikeSharing;
	}

	public void setUseBikeSharing(String useBikeSharing) {
		this.useBikeSharing = useBikeSharing;
	}
	
	public String getBikeSharingCompany() {
		return bikeSharingCompany;
	}

	public void setBikeSharingCompany(String bikeSharingCompany) {
		this.bikeSharingCompany = bikeSharingCompany;
	}

	public String getUsePublicTransport() {
		return usePublicTransport;
	}

	public void setUsePublicTransport(String usePublicTransport) {
		this.usePublicTransport = usePublicTransport;
	}

	public String getFrequentTicketType() {
		return frequentTicketType;
	}

	public void setFrequentTicketType(String frequentTicketType) {
		this.frequentTicketType = frequentTicketType;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
