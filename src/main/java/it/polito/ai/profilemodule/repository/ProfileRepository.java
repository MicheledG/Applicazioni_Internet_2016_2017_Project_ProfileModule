package it.polito.ai.profilemodule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.polito.ai.profilemodule.model.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

	public Profile findOneByUsername(String username);
	public Profile findOneByNickname(String nickname);

}
