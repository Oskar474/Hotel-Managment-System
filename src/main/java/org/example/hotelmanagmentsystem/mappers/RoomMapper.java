package org.example.hotelmanagmentsystem.mappers;

import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface RoomMapper {
    RoomResponse toRoomResponse (Room room);
    Room toRoom(RoomRequest roomRequest);
}
