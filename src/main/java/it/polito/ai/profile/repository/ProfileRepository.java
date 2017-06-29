package it.polito.ai.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.polito.ai.profile.model.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

	public Profile findOneByUsername(String username);
	public Profile findOneByNickname(String nickname);

}
