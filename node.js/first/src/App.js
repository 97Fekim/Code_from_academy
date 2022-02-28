import Color from "./Color";

function App() {
  return (
    <div>
      {[1,2,3,4].map((i) => (
        <Color no={i}>{i}번</Color>
      ))}
    </div>
  );
}

export default App;
