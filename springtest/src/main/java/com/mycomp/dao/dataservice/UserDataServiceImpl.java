package com.mycomp.dao.dataservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycomp.Model.AddressDTO;
import com.mycomp.Model.UserDTO;
import com.mycomp.dao.entity.AddressEntity;
import com.mycomp.dao.entity.UserEntity;
import com.mycomp.dao.repository.UserRepository;

@Service
public class UserDataServiceImpl implements IUserDataService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public Optional<List<UserDTO>> getAllUsers() {
		List<UserEntity> usersEntities = userRepository.findAll();
		return Optional.ofNullable(usersEntities.stream().map(user -> mapEntityToDTO(user)).collect(Collectors.toList()));

	}

	@Override
	public Optional<UserDTO> addUser(UserDTO user) {
		UserEntity userEntity=mapDTOToEntity(user);
		userEntity=userRepository.save(userEntity);
		return Optional.ofNullable(modelMapper.map(userEntity, UserDTO.class));
	}
	
	@Override
	public boolean checkUserExistsById(Long userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public void deleteUser(Long userId) {
			userRepository.deleteById(userId);
	}

	@Override
	public Optional<UserDTO> getUsersById(Long userId) {
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		if (userEntity.isPresent()) {
			return Optional.of(modelMapper.map(userEntity.get(), UserDTO.class));
		}
		return Optional.empty();
	}

	@Override
	public Optional<UserDTO> getUsersByName(String userName) {
		Optional<UserEntity> userEntity = userRepository.findByNameIgnoreCase(userName);
		if (userEntity.isPresent()) {
			return Optional.of(modelMapper.map(userEntity.get(), UserDTO.class));
		}
		return Optional.empty();
	}
	
	private UserDTO mapEntityToDTO(UserEntity source) {
		UserDTO userDTO=new UserDTO();
		userDTO.setId(source.getId());
		userDTO.setAge(source.getAge());
		userDTO.setName(source.getName());
		userDTO.setPassword(source.getPassword());
		List<AddressEntity> addressList=source.getAddressList();
		List<AddressDTO> addressDTOList=addressList!=null?
				addressList.stream().map(address->modelMapper.map(address, AddressDTO.class)).collect(Collectors.toList())
				:new ArrayList<AddressDTO>();
		
//		for(AddressEntity address:addressList) {
//			AddressDTO addressDTO=modelMapper.map(address, AddressDTO.class);
//			addressDTOList.add(addressDTO);
//		}
		userDTO.setAddressList(addressDTOList);
		return userDTO;
	}
	
	private UserEntity mapDTOToEntity(UserDTO source) {
		UserEntity userEntity=new UserEntity();
		//userEntity.setId(source.getId());
		userEntity.setAge(source.getAge());
		userEntity.setName(source.getName());
		userEntity.setPassword(source.getPassword());
		List<AddressDTO> addressList=source.getAddressList();
		//List<AddressEntity> addressDTOList=new ArrayList<AddressEntity>();
		
		List<AddressEntity> addressDTOList=addressList!=null?addressList.stream().
				map(address-> {
					AddressEntity add=modelMapper.map(address, AddressEntity.class);
					//add.setUser(userEntity);
					return add;
				})
				.collect(Collectors.toList())
				:new ArrayList<AddressEntity>();
		/*for(AddressDTO address:addressList) {
			AddressEntity addressEntity=modelMapper.map(address, AddressEntity.class);
			//addressEntity.setUser123(userEntity); // Set at the User entity, now not needed here 
			addressDTOList.add(addressEntity);
		}*/
		userEntity.setAddressList(addressDTOList);
		return userEntity;
	}

}
