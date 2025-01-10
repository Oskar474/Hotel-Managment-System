package org.example.hotelmanagmentsystem.mappers;

import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.mapstruct.Mapper;

@Mapper

public interface RoomMapper {
    Room toRoom(RoomRequest roomRequest);
    RoomResponse toRoomResponse (Room room);
}
