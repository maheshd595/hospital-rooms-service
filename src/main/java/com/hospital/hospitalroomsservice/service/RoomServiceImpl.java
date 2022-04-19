package com.hospital.hospitalroomsservice.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalroomsservice.Utils.Constants;
import com.hospital.hospitalroomsservice.entities.AssignedRooms;
import com.hospital.hospitalroomsservice.entities.Provider;
import com.hospital.hospitalroomsservice.entities.RoomStatus;
import com.hospital.hospitalroomsservice.entities.RoomType;
import com.hospital.hospitalroomsservice.entities.Rooms;
import com.hospital.hospitalroomsservice.modal.AssignProvider;
import com.hospital.hospitalroomsservice.modal.AssignProvidersVO;
import com.hospital.hospitalroomsservice.modal.AssignedRoomsVO;
import com.hospital.hospitalroomsservice.modal.FilterVO;
import com.hospital.hospitalroomsservice.modal.OptionsVO;
import com.hospital.hospitalroomsservice.modal.RoomsVO;
import com.hospital.hospitalroomsservice.repository.AssignedRoomsRepository;
import com.hospital.hospitalroomsservice.repository.ProviderRepository;
import com.hospital.hospitalroomsservice.repository.RoomStatusRepository;
import com.hospital.hospitalroomsservice.repository.RoomTypeRepository;
import com.hospital.hospitalroomsservice.repository.RoomsRepository;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomsRepository roomRepository;
	@Autowired
	RoomTypeRepository roomTypeRepo;
	@Autowired
	RoomStatusRepository roomStatusRepo;
	@Autowired
	ProviderRepository providerRepo;
	@Autowired
	AssignedRoomsRepository assignedRoomRepo;

	public static Map<Integer, String> weeks;

	static {
		weeks = new HashMap<Integer, String>() {
			{
				put(1, "Sun");
				put(2, "Mun");
				put(3, "Tue");
				put(4, "Wed");
				put(5, "Thu");
				put(6, "Fri");
				put(7, "Sat");
			}
		};
	}

	@Override
	public List<OptionsVO> getAllRooms() {
		List<OptionsVO> returnVOs = new ArrayList<OptionsVO>();
		List<Rooms> rooms = roomRepository.findAll();
		for (Rooms room : rooms) {
			OptionsVO roomsVO = new OptionsVO();
			roomsVO.setValue(room.getId());
			roomsVO.setLabel(room.getName());
			returnVOs.add(roomsVO);
		}
		return returnVOs;
	}

	@Override
	public List<RoomsVO> getRoomsByLocation(String locationIds) {
		List<RoomsVO> returnVOs = new ArrayList<RoomsVO>();
		List<Rooms> rooms;
		if (locationIds != null && !locationIds.isEmpty() && locationIds != "null") {
			List<Integer> ids = Stream.of(locationIds.split(",")).map(Integer::parseInt).collect(Collectors.toList());
			rooms = roomRepository.findByLocationIdIn(ids);

		} else {
			rooms = roomRepository.findAll();
		}
		for (Rooms room : rooms) {
			RoomsVO roomsVO = new RoomsVO();
			roomsVO.setValue(room.getId());
			roomsVO.setLabel(room.getName());
			returnVOs.add(roomsVO);
		}
		return returnVOs;
	}

	@Override
	public List<OptionsVO> getAllRoomTypes() {
		List<OptionsVO> returnVOs = new ArrayList<OptionsVO>();
		List<RoomType> roomTypes = roomTypeRepo.findAll();
		for (RoomType type : roomTypes) {
			OptionsVO optionVO = new OptionsVO();
			optionVO.setValue(type.getId());
			optionVO.setLabel(type.getType());
			returnVOs.add(optionVO);
		}
		return returnVOs;
	}

	@Override
	public List<OptionsVO> getAllRoomStatus() {
		List<OptionsVO> returnVOs = new ArrayList<OptionsVO>();
		List<RoomStatus> roomStatus = roomStatusRepo.findAll();
		for (RoomStatus status : roomStatus) {
			OptionsVO optionVO = new OptionsVO();
			optionVO.setValue(status.getId());
			optionVO.setLabel(status.getStatus());
			returnVOs.add(optionVO);
		}
		return returnVOs;
	}

	@Override
	public List<OptionsVO> getAllProviders() {
		List<OptionsVO> returnVOs = new ArrayList<OptionsVO>();
		List<Provider> providers = providerRepo.findAll();
		for (Provider provider : providers) {
			OptionsVO optionVO = new OptionsVO();
			optionVO.setValue(provider.getId());
			optionVO.setLabel(provider.getName());
			returnVOs.add(optionVO);
		}
		return returnVOs;
	}

	@Override
	public List<AssignedRoomsVO> getAllAssignedRooms(FilterVO filters) {

		List<AssignedRooms> assignedRooms = assignedRoomRepo.findAll();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

		List<AssignedRoomsVO> returnList = new ArrayList<>();
		for (AssignedRooms room : assignedRooms) {

			if (filters.getStartDate() != null || filters.getEndDate() != null) {
				if (filters.getStartDate() == null) {
					filters.setStartDate(filters.getEndDate());
				}
				if (filters.getEndDate() == null) {
					filters.setEndDate(filters.getStartDate());
				}
				if (!(room.getFromDate().getTime() >= filters.getStartDate().getTime()
						&& room.getFromDate().getTime() <= filters.getEndDate().getTime()))

				{
					continue;
				}
			}

			if (!filters.getWeeks().isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(room.getFromDate());
				if (!filters.getWeeks().contains(weeks.get(calendar.get(Calendar.DAY_OF_WEEK)))) {
					continue;
				}
			}

			if (!filters.getSessions().isEmpty()) {
				if (!filters.getSessions().contains(room.getSession())) {
					continue;
				}
			}

			if (!filters.getRoomStatus().isEmpty()) {
				if (!filters.getRoomStatus().contains(room.getRoomStatus().getId())) {
					continue;
				}
			}
			if (!filters.getRoomTypes().isEmpty()) {
				if (!filters.getRoomTypes().contains(room.getRoomType().getId())) {
					continue;
				}
			}
			if (!filters.getLocations().isEmpty()) {
				if (!filters.getLocations().contains(room.getRooms().getLocation().getId())) {
					continue;
				}
			}
			if (!filters.getRooms().isEmpty()) {
				if (!filters.getRooms().contains(room.getRooms().getId())) {
					continue;
				}
			}
			if (!filters.getProviders().isEmpty()) {
				if (room.getProvider() == null || !filters.getProviders().contains(room.getProvider().getId())) {
					continue;
				}
			}

			AssignedRoomsVO roomVO = new AssignedRoomsVO();
			roomVO.setId(room.getId());
			roomVO.setSession(room.getSession());
			roomVO.setStartDate(room.getFromDate());
			roomVO.setEndDate(room.getToDate());
			roomVO.setStartDateStr(simpleDateFormat.format(room.getFromDate()));
			roomVO.setEndDateStr(simpleDateFormat.format(room.getToDate()));
			roomVO.setRoomName(room.getRooms().getName());
			roomVO.setLocation(room.getRooms().getLocation().getName());
			roomVO.setStatus(room.getRoomStatus().getStatus());
			roomVO.setRoomType(room.getRoomType().getType());
			if (room.getProvider() != null) {
				roomVO.setProviderId(room.getProvider().getId());
				roomVO.setProvider(room.getProvider().getName());
			}
			returnList.add(roomVO);
		}
		return returnList;
	}

	@Override
	public String assignProviderToRoom(AssignProvidersVO assignProviders) {
		if (assignProviders.getAssignProvider() != null) {
			Map<String, Integer> roomStatus = roomStatusRepo.findAll().stream()
					.collect(Collectors.toMap(RoomStatus::getStatus, RoomStatus::getId));
			for (AssignProvider assignProviderVO : assignProviders.getAssignProvider()) {
				int roomTypeId = roomStatus.get(Constants.OPEN);
				if (assignProviderVO.getProviderId() > 0) {
					roomTypeId = roomStatus.get(Constants.BLOCKED);
				}
				assignedRoomRepo.updateProviderForRoom(
						(assignProviderVO.getProviderId() > 0 ? assignProviderVO.getProviderId() : null),
						assignProviderVO.getId(), roomTypeId);
			}
		}
		return "DONE";
	}

	@Override
	public List<OptionsVO> getAvilableProviders(Date date, String session, int providerId) {
		List<OptionsVO> returnVOs = new ArrayList<OptionsVO>();
		List<Integer> assignedProviders = assignedRoomRepo.getAssingedRoomsByDateAndSesion(date, session);
		List<Provider> providers = providerRepo.findAll();
		for (Provider provider : providers) {
			if (assignedProviders.contains(provider.getId())) {
				if (providerId > 0 && providerId == provider.getId()) {

				} else {
					continue;
				}
			}
			OptionsVO optionVO = new OptionsVO();
			optionVO.setValue(provider.getId());
			optionVO.setLabel(provider.getName());
			returnVOs.add(optionVO);
		}
		return returnVOs;
	}

}
