// import logo from './logo.svg';
import './App.css';
import Green from './components/Green';

function App() {
  var arr = ["사랑","믿음","증오","복수","행복"]

  const g = () => {
    console.log("나는 눌린다.");
  }
  return (
    <div className="App">
      {arr.map((data, key)=>(
        <Green key={key} a="홍길동" b="홍말자" c={key}>
          {data}
        </Green>
      ))}
        <div>
          <button onClick={g}>눌러라</button>
        </div>
      </div>
  );
}

export default App;
