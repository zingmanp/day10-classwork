import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Full Stack App heading', () => {
  render(<App />);
  const headingElement = screen.getByText(/Full Stack App/i);
  expect(headingElement).toBeInTheDocument();
});