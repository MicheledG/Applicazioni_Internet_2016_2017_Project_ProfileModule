package it.polito.ai.profilemodule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "profiles")
public class Profile {

	@Id
	private String profileId;
	
	@JsonIgnore
	@Indexed(unique = true)
	private String username;
	
	@Indexed(unique = true)
	private String nickname;
	
	private String gender;
	private int age;
	private String education;
	private String job;
	
	private String ownCar;
	private String fuel;
	private int registrationCarYear;
	private String useCarSharing;
	private String carSharingCompany;
	
	private String useBike;
	private String useownBike;
	private String useBikeSharing;
	private String bikeSharingCompany;
	
	private String usePublicTransport;
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
