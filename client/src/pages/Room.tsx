import { useEffect, useState } from "react";
import "../App.css";
import reactLogo from "../assets/react.svg";

const Room = () => {
  const [rooms, setRooms] = useState([]);

  const createRoom = (name: string) => {
    fetch("/api/rooms", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name }),
    })
      .then((res) => res.json())
      .then((room) => {
        setRooms([...rooms, room]);
      });
  };

  // fetch all rooms from server
  useEffect(() => {
    fetch("/api/rooms")
      .then((res) => res.json())
      .then((rooms) => {
        setRooms(rooms);
      });
  }, []);

  return (
    <>
      {rooms.map((room) => (
        <div key={room.id}>
          <a href={`/room/${room.id}`}>{room.name}</a>
        </div>
      ))}
      <div>
        <a href="https://vitejs.dev" target="_blank"></a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Fodinha</h1>
      {/* form to create a room  */}
      <form
        onSubmit={(e) => {
          e.preventDefault();
          createRoom(e.target[0].value);
        }}
      >
        <input type="text" placeholder="Room name" />
        <button type="submit">Create Room</button>
      </form>
    </>
  );
};

export default Room;
