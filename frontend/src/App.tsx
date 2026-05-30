import { Button } from "@/components/ui/button"

export function App() {
  return (
    <div className="bg-gray-200 dark:bg-blue-700">
      <header className="absolute inset-x-0 top-0 z-50">
        <nav className="flex items-center p-6 lg:px-8">
          <div className="flex lg:flex-2">LOGO</div>

          <div className="flex lg:hidden"></div>

          <div className="hidden lg:flex lg:flex-1 lg:justify-end">
            <Button >Expert Area</Button>
          </div>
        </nav>
      </header>

    </div>
  )
}

export default App
