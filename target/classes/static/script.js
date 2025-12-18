async function loadTeas() {
  const query = document.getElementById('searchInput').value;
  const minPrice = parseFloat(document.getElementById('minPrice').value) || undefined;
  const maxPrice = parseFloat(document.getElementById('maxPrice').value) || undefined;

  let url = `/api/tea/search?`;
  if (query) url += `query=${encodeURIComponent(query)}&`;
  if (minPrice !== undefined) url += `minPrice=${minPrice}&`;
  if (maxPrice !== undefined) url += `maxPrice=${maxPrice}`;

  const response = await fetch(url);
  const teas = await response.json();

  const container = document.getElementById('teaList');
  container.innerHTML = '';

  teas.forEach(tea => {
    const card = document.createElement('div');
    card.className = 'tea-card';
    card.innerHTML = `
      <img src="${tea.imageUrl}" alt="${tea.sort}" class="tea-image">
      <h3>${tea.sort}</h3>
      <p><strong>Вид:</strong> ${tea.kind}</p>
      <p><strong>Добавки:</strong> ${tea.additives || 'Нет'}</p>
      <p><strong>Производитель:</strong> ${tea.manufacturer}</p>
      <p><strong>Вес:</strong> ${tea.weight} г</p>
      <p><strong>Цена:</strong> ${tea.price} руб.</p>
    `;
    container.appendChild(card);
  });
}

window.onload = () => {
  loadTeas();
};